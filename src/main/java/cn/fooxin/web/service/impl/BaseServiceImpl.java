package cn.fooxin.web.service.impl;


import cn.fooxin.web.domain.BaseDomain;
import cn.fooxin.web.repository.BaseRepository;
import cn.fooxin.web.service.BaseService;
import cn.fooxin.web.utils.Utils;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujianyin on 2017/11/17.
 */

@Transactional
public abstract class BaseServiceImpl<T extends BaseDomain, R extends BaseRepository<T>> implements BaseService<T> {
    private final static String clsName = BaseRepository.class.getName();

    /**
     * 更新记录状态 SQL
     */
    private String SQL_UPDATE_STATUS_SINGLE = "UPDATE %s SET status = :status WHERE sid = :sid";
    private String SQL_UPDATE_STATUS_BATCH  = "UPDATE %s SET status = :status WHERE sid IN (:sids)";

    /**
     * 根据状态查询 SQL
     */
    private String SQL_SELECT_STATUS_SINGLE     = "SELECT E FROM %s E WHERE status = :status";
    private String SQL_SELECT_STATUS_IN         = "SELECT E FROM %s E WHERE status IN (:status)";
    private String SQL_SELECT_STATUS_NOT_SINGLE = "SELECT E FROM %s E WHERE status != :status";
    private String SQL_SELECT_STATUS_NOT_IN     = "SELECT E FROM %s E WHERE status NOT IN (:status)";

    /**
     * 实体表名
     */
    private String TABLE_NAME;
    /**
     * 实体类名
     */
    private String CLASS_NAME;

    @PersistenceContext
    private EntityManager em;

    protected R baseRepository;

    public abstract void setRepository(R repository);

    @PostConstruct
    public void init() {
        Type[] types = baseRepository.getClass().getGenericInterfaces();
        if (null != types && types.length > 0) {
            Type type = types[0];
            try {
                Class<?> cls = Class.forName(type.getTypeName());
                types = cls.getGenericInterfaces();
                if (null != types && types.length > 0) {
                    type = types[0];
                    String name = type.getTypeName().replace(clsName + "<", "").replace(">", "");
                    cls = Class.forName(name);
                    Method method = cls.getMethod("getTableName");
                    if (null != method) {
                        TABLE_NAME = String.valueOf(method.invoke(cls.newInstance()));
                        SQL_UPDATE_STATUS_SINGLE = String.format(SQL_UPDATE_STATUS_SINGLE, TABLE_NAME);
                        SQL_UPDATE_STATUS_BATCH = String.format(SQL_UPDATE_STATUS_BATCH, TABLE_NAME);

                    }

                    method = cls.getMethod("getClsName");
                    if (null != method) {
                        CLASS_NAME = String.valueOf(method.invoke(cls.newInstance()));
                        SQL_SELECT_STATUS_SINGLE = String.format(SQL_SELECT_STATUS_SINGLE, CLASS_NAME, CLASS_NAME);
                        SQL_SELECT_STATUS_IN = String.format(SQL_SELECT_STATUS_IN, CLASS_NAME, CLASS_NAME);

                        SQL_SELECT_STATUS_NOT_SINGLE = String.format(SQL_SELECT_STATUS_NOT_SINGLE, CLASS_NAME, CLASS_NAME);
                        SQL_SELECT_STATUS_NOT_IN = String.format(SQL_SELECT_STATUS_NOT_IN, CLASS_NAME, CLASS_NAME);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public T findOne(Long sid) {
        return baseRepository.findOne(sid);
    }

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public void remove(Long sid) {
        setStatus(-1, sid);
    }

    @Override
    public void remove(List<Long> sids) {
        setStatus(-1, sids);
    }

    @Override
    public void remove(Long[] sids) {
        setStatus(-1, sids);
    }

    @Override
    public void disable(Long sid) {
        setStatus(0, sid);
    }

    @Override
    public void disable(List<Long> sids) {
        setStatus(0, sids);
    }

    @Override
    public void disable(Long[] sids) {
        setStatus(0, sids);
    }

    @Override
    public void enable(Long sid) {
        setStatus(1, sid);
    }

    @Override
    public void enable(List<Long> sids) {
        setStatus(1, sids);
    }

    @Override
    public void enable(Long[] sids) {
        setStatus(1, sids);
    }

    @Override
    public void updateStatus(Integer status, Long sid) {
        setStatus(status, sid);
    }

    @Override
    public void updateStatus(Integer status, List<Long> sids) {
        setStatus(status, sids);
    }

    @Override
    public void updateStatus(Integer status, Long[] sids) {
        setStatus(status, sids);
    }

    @Override
    public List<T> findByStatus(Integer status) {
        return findByStatus(status, true);
    }

    @Override
    public List<T> findByStatus(Integer[] status) {
        return findByStatus(status, true);
    }

    @Override
    public List<T> findByStatus(List<Integer> status) {
        return findByStatus(status, true);
    }

    @Override
    public List<T> findByNotStatus(Integer status) {
        return findByStatus(status, false);
    }

    @Override
    public List<T> findByNotStatus(Integer[] status) {
        return findByStatus(status, false);
    }

    @Override
    public List<T> findByNotStatus(List<Integer> status) {
        return findByStatus(status, false);
    }

    /**
     * 更新记录状态
     *
     * @param status
     * @param sid
     */
    protected void setStatus(Integer status, Object sid) {
        if (!Utils.isEmpty(TABLE_NAME)) {
            Query query;
            if (sid instanceof Long[] || sid instanceof List<?>) {
                query = em.createNativeQuery(SQL_UPDATE_STATUS_BATCH);

                List<String> sids = new ArrayList<>();
                if (sid instanceof Long[]) {
                    for (Long s : (Long[]) sid) {
                        sids.add(String.valueOf(s));
                    }
                } else {
                    for (Object s : (List<?>) sid) {
                        sids.add(String.valueOf(s));
                    }
                }
                query.setParameter("sids", sids);
            } else {
                query = em.createNativeQuery(SQL_UPDATE_STATUS_SINGLE);
                query.setParameter("sid", sid);
            }
            query.setParameter("status", status);
            query.executeUpdate();
        }
    }

    protected List<T> findByStatus(Object status, boolean inOrNot) {
        if (!Utils.isEmpty(TABLE_NAME)) {
            Query query;
            if (status instanceof Integer[] || status instanceof List<?>) {
                query = em.createQuery(inOrNot ? SQL_SELECT_STATUS_IN : SQL_SELECT_STATUS_NOT_IN);

                if (status instanceof Integer[]) {
                    List<Integer> statusList = new ArrayList<>();
                    for (Integer s : (Integer[]) status) {
                        statusList.add(s);
                    }
                    query.setParameter("status", statusList);
                } else {
                    query.setParameter("status", status);
                }
            } else {
                query = em.createQuery(inOrNot ? SQL_SELECT_STATUS_SINGLE : SQL_SELECT_STATUS_NOT_SINGLE);
                query.setParameter("status", status);
            }
            return query.getResultList();
        }

        return new ArrayList<>();
    }
}

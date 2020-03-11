package demo.eureka.client.tmp;

/**
 * 租约管理
 * @param <T>
 */
public interface LeaseManager<T> {

    /**
     * 用于注册新的服务实例
     * <p>
     * Assign a new Lease to the passed in {@link T}.
     *
     * @param r             - T to register
     * @param leaseDuration
     * @param isReplication - whether this is a replicated entry from another eureka node.
     */
    void register(T r, int leaseDuration, boolean isReplication);

    /**
     * 用于删除服务实例
     * <p>
     * Cancel the  Lease associated w/ the passed in <code>appName</code>
     * and <code>id</code>.
     *
     * @param appName       - unique id of the application.
     * @param id            - unique id within appName.
     * @param isReplication - whether this is a replicated entry from another eureka node.
     * @return true, if the operation was successful, false otherwise.
     */
    boolean cancel(String appName, String id, boolean isReplication);

    /**
     * 用于心跳操作，维持租约
     * <p>
     * Renew the Lease associated w/ the passed in <code>appName</code>
     * and <code>id</code>.
     *
     * @param id            - unique id within appName
     * @param isReplication - whether this is a replicated entry from another ds node
     * @return whether the operation of successful
     */
    boolean renew(String appName, String id, boolean isReplication);

    /**
     * 用于剔除租约国企的实例
     * <p>
     * Evict {@link T}s with expired  Lease(s).
     */
    void evict();
}
///*
// * Copyright 2012 Netflix, Inc.
// *
// *    Licensed under the Apache License, Version 2.0 (the "License");
// *    you may not use this file except in compliance with the License.
// *    You may obtain a copy of the License at
// *
// *        http://www.apache.org/licenses/LICENSE-2.0
// *
// *    Unless required by applicable law or agreed to in writing, software
// *    distributed under the License is distributed on an "AS IS" BASIS,
// *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *    See the License for the specific language governing permissions and
// *    limitations under the License.
// */
//package demo.eureka.client;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.LinkedHashSet;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.Function;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonRootName;
//import com.google.inject.ProvidedBy;
//import com.netflix.appinfo.DataCenterInfo;
//import com.netflix.appinfo.providers.Archaius1VipAddressResolver;
//import com.netflix.appinfo.providers.EurekaConfigBasedInstanceInfoProvider;
//import com.netflix.appinfo.providers.VipAddressResolver;
//import com.netflix.discovery.converters.Auto;
//import com.netflix.discovery.converters.EurekaJacksonCodec.InstanceInfoSerializer;
//import com.netflix.discovery.provider.Serializer;
//import com.netflix.discovery.util.StringCache;
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamOmitField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * The class that holds information required for registration with
// * <tt>Eureka Server</tt> and to be discovered by other components.
// * <p>
// * <code>@Auto</code> annotated fields are serialized as is; Other fields are
// * serialized as specified by the <code>@Serializer</code>.
// * </p>
// *
// * @author Karthik Ranganathan, Greg Kim
// */
//@JsonRootName("instance")
//public class InstanceInfo {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(InstanceInfo.class);
//
//    public static final int DEFAULT_PORT = 7001;
//    public static final int DEFAULT_SECURE_PORT = 7002;
//    public static final int DEFAULT_COUNTRY_ID = 1; // US
//
//    /**
//     * 实例Id
//     */
//    private volatile String instanceId;
//
//    /**
//     * 应用名称
//     */
//    private volatile String appName;
//
//    /**
//     * 应用组名称
//     */
//    private volatile String appGroupName;
//
//    /**
//     * ip地址
//     */
//    private volatile String ipAddr;
//
//    private static final String SID_DEFAULT = "na";
//
//    /**
//     * 废弃的属性 sid 默认是na
//     */
//    @Deprecated
//    private volatile String sid = SID_DEFAULT;
//
//    /**
//     * 端口号 默认是7001
//     */
//    private volatile int port = DEFAULT_PORT;
//
//    /**
//     * https端口号默认是7002
//     */
//    private volatile int securePort = DEFAULT_SECURE_PORT;
//
//
//    /**
//     * 应用实例首页url
//     */
//    private volatile String homePageUrl;
//
//    /**
//     * 应用实例状态页url
//     */
//    private volatile String statusPageUrl;
//    /**
//     * 应用实例检查是否健康的url
//     */
//    private volatile String healthCheckUrl;
//    /**
//     * 应用实例检查是否健康的 https url
//     */
//    private volatile String secureHealthCheckUrl;
//
//    /**
//     * 虚拟的ip地址
//     */
//    private volatile String vipAddress;
//    /**
//     * https的虚拟的ip地址
//     */
//    private volatile String secureVipAddress;
//    @XStreamOmitField
//    private String statusPageRelativeUrl;
//    @XStreamOmitField
//    private String statusPageExplicitUrl;
//    @XStreamOmitField
//    private String healthCheckRelativeUrl;
//    @XStreamOmitField
//    private String healthCheckSecureExplicitUrl;
//    @XStreamOmitField
//    private String vipAddressUnresolved;
//    @XStreamOmitField
//    private String secureVipAddressUnresolved;
//    @XStreamOmitField
//    private String healthCheckExplicitUrl;
//    /**
//     * 废弃的属性 默认是1 代表US
//     */
//    @Deprecated
//    private volatile int countryId = DEFAULT_COUNTRY_ID; // Defaults to US
//    private volatile boolean isSecurePortEnabled = false;
//    private volatile boolean isUnsecurePortEnabled = true;
//
//    public interface DataCenterInfo {
//        enum Name {Netflix, Amazon, MyOwn}
//
//        com.netflix.appinfo.DataCenterInfo.Name getName();
//    }
//
//    /**
//     * 数据中心的info Netflix/Amazon/MyOwn
//     */
//    private volatile DataCenterInfo dataCenterInfo;
//    /**
//     * 主机名称
//     */
//    private volatile String hostName;
//
//
//    public enum InstanceStatus {
//        UP, // Ready to receive traffic
//        DOWN, // Do not send traffic- healthcheck callback failed
//        STARTING, // Just about starting- initializations to be done - do not
//        // send traffic
//        OUT_OF_SERVICE, // Intentionally shutdown for traffic
//        UNKNOWN;
//
//        public static InstanceStatus toEnum(String s) {
//            if (s != null) {
//                try {
//                    return InstanceStatus.valueOf(s.toUpperCase());
//                } catch (IllegalArgumentException e) {
//                    // ignore and fall through to unknown
//                    logger.debug("illegal argument supplied to InstanceStatus.valueOf: {}, defaulting to {}", s, UNKNOWN);
//                }
//            }
//            return UNKNOWN;
//        }
//    }
//
//    /**
//     * 实例状态 UP DOWN STARTING OUT_OF_SERVICE UNKNOWN
//     */
//    private volatile InstanceStatus status = InstanceStatus.UP;
//    /**
//     * 外界需要强制覆盖的状态值 默认为UNKNOWN
//     */
//    private volatile InstanceStatus overriddenStatus = InstanceStatus.UNKNOWN;
//    @XStreamOmitField
//    private volatile boolean isInstanceInfoDirty = false;
//
//    /**
//     * 默认的租约的类
//     */
//    public class LeaseInfo {
//        public static final int DEFAULT_LEASE_RENEWAL_INTERVAL = 30;
//        public static final int DEFAULT_LEASE_DURATION = 90;
//
//        // Client settings
//        /**
//         * Client 续约的时间间隔 默认30s
//         */
//        private int renewalIntervalInSecs = DEFAULT_LEASE_RENEWAL_INTERVAL;
//        /**
//         * Client 设定续约的有效时长 默认90s
//         */
//        private int durationInSecs = DEFAULT_LEASE_DURATION;
//
//        // Server populated
//        /**
//         * Server 设定的改租约的 第一次注册 时间
//         */
//        private long registrationTimestamp;
//        /**
//         * Server 设定的改租约的 最后一次续约 时间
//         */
//        private long lastRenewalTimestamp;
//        /**
//         * Server 设定的改租约的 剔除 时间
//         */
//        private long evictionTimestamp;
//        /**
//         * Server 设定的改租约的 标记为Up 时间
//         */
//        private long serviceUpTimestamp;
//    }
//
//    /**
//     * 租约信息
//     */
//    private volatile LeaseInfo leaseInfo;
//    /**
//     * 标识是否是discoveryServer
//     */
//    private volatile Boolean isCoordinatingDiscoveryServer = Boolean.FALSE;
//
//    /**
//     * 应用实例的元数据信息
//     */
//    private volatile Map<String, String> metadata;
//
//    /**
//     * 状态实例最后更新时间
//     */
//    private volatile Long lastUpdatedTimestamp;
//
//    /**
//     * 应用最新的过期时间
//     */
//    private volatile Long lastDirtyTimestamp;
//
//    public enum ActionType {
//        ADDED, // Added in the discovery server
//        MODIFIED, // Changed in the discovery server
//        DELETED
//        // Deleted from the discovery server
//    }
//
//    /**
//     * 标识Eureka Server对该实例进行的操作 ADDED / MODIFIED / DELETED
//     */
//    private volatile ActionType actionType;
//    /**
//     * 在AWS中的 autoscaling group的名称??
//     */
//    private volatile String asgName;
//    private String version = VERSION_UNKNOWN;
//
//}

/**
 * 
 */
package com.jzsk.filecode.constants;

public class InterfaceConstants {

	/**
	 * 接口
	 */
	/** 服务器地址 */
	public static final String SERVER_ADDRESS = "http://120.76.76.165:8090/web";

	/*
	 * 农场管理
	 */
	/** 农场管理-农场列表 */
	public static final String FARM_LIST = SERVER_ADDRESS + "/farm/queryForFarmList";
	/** 农场管理-农场添加 */
	public static final String FARM_ADD = SERVER_ADDRESS + "/farm/addFarm";
	/** 农场管理-农场编辑 */
	public static final String FARM_EDIT = SERVER_ADDRESS + "/farm/updateFarm";
	/** 农场管理-农场删除 */
	public static final String FARM_DELETE = SERVER_ADDRESS + "/farm/delFarm";
	/** 农场管理-农场详细 */
	public static final String FARM_DETAIL = SERVER_ADDRESS + "/farm/queryForFarmDetails";
	/** 农场管理-农场信息列表 */
	public static final String FARM_INFO_LIST = SERVER_ADDRESS + "/farm/queryMultiFarmInfo";
	/** 农场管理-农场详细-区域列表 */
	public static final String FARM_DETAIL_AREA_LIST = SERVER_ADDRESS + "/zone/queryZoneList";
	/** 农场管理-农场详细-传感器分类列表 */
	public static final String FARM_SENSOR_TYPE_LIST = SERVER_ADDRESS + "/sensorType/queryForSensorType";
	/** 农场管理-农场详细-传感器（数值型）分类列表 */
	public static final String FARM_SENSOR_TYPE_LIST_TO_NUMBER = SERVER_ADDRESS + "/sensorType/querySensorTypeToNumber";
	/** 农场管理-农场区域添加 */
	public static final String FARM_AREA_ADD = SERVER_ADDRESS + "/zone/addZone";
	/** 农场管理-农场区域编辑 */
	public static final String FARM_AREA_EDIT = SERVER_ADDRESS + "/zone/updateZone";
	/** 农场管理-农场区域删除 */
	public static final String FARM_AREA_DELETE = SERVER_ADDRESS + "/zone/delZone";
	/** 农场管理-农场配置 */
	public static final String FARM_CONFIG = SERVER_ADDRESS + "/elementMap/queryElementMapByFarmId";
	/** 农场管理-农场配置添加 */
	public static final String FARM_CONFIG_ADD = SERVER_ADDRESS + "/elementMap/addElementMap";
	/** 农场管理-农场配置删除 */
	public static final String FARM_CONFIG_DELETE = SERVER_ADDRESS + "/elementMap/delElementMap";
	/** 农场管理-农场配置编辑 */
	public static final String FARM_CONFIG_EDIT = SERVER_ADDRESS + "/elementMap/updateElementMap";
	/** 农场管理-农场报表-传感器列表 */
	public static final String FARM_SENSOR_LIST = SERVER_ADDRESS + "/sensor/querySensorList";
	/** 农场管理-农场报表-传感器列表(数据类) */
	public static final String FARM_SENSOR_DATA_LIST = SERVER_ADDRESS + "/sensor/querySensorContrastiveAnalysisReport";
	/** 农场管理-农场报表-选择传感器 */
	public static final String FARM_SENSOR_SELECT = SERVER_ADDRESS + "/sensor/querySensorItemForFarm";
	/** 农场管理-农场报表-选择传感器 */
	public static final String FARM_SENSOR_SELECT_FOR_NUMBER = SERVER_ADDRESS + "/sensor/querySensorForNumber";
	/** 农场管理-农场报表-单个传感器详情（通过传感器ID查询） */
	public static final String FARM_SENSOR_DETIL_BY_SENSOR_ID = SERVER_ADDRESS + "/sensor/querySensorBySensorId";
	/** 农场管理-农场报表-传感器详情 */
	public static final String FARM_SENSOR_DETIL = SERVER_ADDRESS + "/sensor/querySensorReportView";
	/** 农场管理-农场报表-传感器对比分析详情 */
	public static final String FARM_SENSOR_COMPARATIVE_ANALYSIS_DETIL = SERVER_ADDRESS
			+ "/sensor/querySensorContrastiveAnalysisView";
	/** 农场管理-农场报表-流程控制记录表 */
	public static final String FARM_FLOW_CTRL_RECORD_LIST = SERVER_ADDRESS
			+ "/flowCtrlRecord/queryForFlowCtrlRecordList";
	/** 农场管理-农场报表-流程控制详情 */
	public static final String FARM_FLOW_CTRL_RECORD_DETIL = SERVER_ADDRESS + "/flowCtrl/queryFlowCtrlDetailInfo";
	/** 农场管理-农场报表-流程控制删除 */
	public static final String FARM_FLOW_CTRL_RECORD_DELETE = SERVER_ADDRESS + "/flowCtrlRecord/delFlowCtrlRecord";
	/** 农场管理-农场报表-流程控制编辑 */
	public static final String FARM_FLOW_CTRL_RECORD_EDIT = SERVER_ADDRESS + "/flowCtrl/updateFlowCtrl";
	/** 农场管理-农场报表-触发控制记录表 */
	public static final String FARM_TRIGGER_CTRL_RECORD_LIST = SERVER_ADDRESS
			+ "/triggerRecord/queryForTriggerRecordList";
	/** 农场管理-农场报表-触发控制记录表删除 */
	public static final String FARM_TRIGGER_CTRL_RECORD_DELETE = SERVER_ADDRESS + "/triggerRecord/delTriggerRecord";
	/** 农场管理-农场报表-触发控制记录表详情 */
	public static final String FARM_TRIGGER_CTRL_RECORD_DETAIL = SERVER_ADDRESS + "/trigger/queryTriggerByTriggerId";
	/** 农场管理-农场报表-告警记录表 */
	public static final String FARM_REPORT_WARNING = SERVER_ADDRESS + "/alarmRecord/queryAlarmecordForFarm";
	/** 农场管理-农场报表-告警记录删除 */
	public static final String FARM_REPORT_WARNING_DELETE = SERVER_ADDRESS + "/alarmRecord/delAlarmRecord";
	/** 农场管理-农场报表-策略控制记录表 */
	public static final String FARM_REPORT_STRATEGY_OPERATE_LIST = SERVER_ADDRESS
			+ "/strategyCtlRecord/queryStrategyCtlRecordList";
	/** 农场管理-农场报表-策略控制记录删除 */
	public static final String FARM_REPORT_STRATEGY_OPERATE_DELETE = SERVER_ADDRESS
			+ "/strategyCtlRecord/delStrategyCtlRecord";
	/** 农场管理-农场报表-策略控制记录详情 */
	public static final String FARM_REPORT_STRATEGY_OPERATE_DETIL = SERVER_ADDRESS
			+ "/strategyCtlRecord/queryStrategyCtlRecordInfo";
	/** 农场管理-农场报表-单点操作记录表 */
	public static final String FARM_REPORT_SINGLE_OPERATE_LIST = SERVER_ADDRESS
			+ "/sensorCtlRecord/querySensorCtlRecordList";
	/** 农场管理-农场报表-单点操作记录删除 */
	public static final String FARM_REPORT_SINGLE_OPERATE_DELETE = SERVER_ADDRESS
			+ "/sensorCtlRecord/delSensorCtlRecord";
	/** 返回单个农场信息 */
	public static final String FARM_INFO = SERVER_ADDRESS + "/farm/queryOneFarmInfoById";
	/** 农场管理-农场报表-设备状态记录列表 */
	public static final String FARM_REPORT_QUERY_DEVICE_STATUS_LIST = SERVER_ADDRESS
			+ "/deviceStateRecord/queryDeviceStateForFarmReport";
	/** 农场管理-农场报表-删除设备状态记录 */
	public static final String FARM_REPORT_DELETE_DEVICE_STATUS_RECORD = SERVER_ADDRESS
			+ "/deviceStateRecord/delDeviceStateRecord";
	/** 农场管理-开关型传感器类型列表 */
	public static final String FARM_SWITCH_SENSOR_TYPE_LIST = SERVER_ADDRESS + "/sensorType/querysensorTypeByFarmId";

	/** 农场筛选 */
	/** 农场筛选-农场列表 */
	public static final String FARM_SELECTION_LIST = SERVER_ADDRESS + "/farm/queryForAllFarmInfo";

	/*
	 * 首页
	 */
	/** 首页显示-管理员 */
	public static final String HOME_PAGE_ADMIN = SERVER_ADDRESS + "/homePage/adminHomePage";
	/** 首页显示-管理员-农场刷新 */
	public static final String HOME_PAGE_ADMIN_FARM_REFRESH = SERVER_ADDRESS + "/homePage/queryAdminFarm";
	/** 首页显示-管理员-农场计划任务 */
	public static final String HOME_PAGE_ADMIN_FARM_TASK_STATE = SERVER_ADDRESS + "/homePage/queryTaskStateForCalendar";
	/** 首页显示-农场主 */
	public static final String HOME_PAGE_FARMER = SERVER_ADDRESS + "/homePage/farmerHomePage";
	/** 首页显示-农场任务状态统计 */
	public static final String HOME_PAGE_QUERY_FARM_STATE = SERVER_ADDRESS + "/homePage/queryFarmStateForCount";
	/** 首页显示-气象五要素 */
	public static final String HOME_PAGE_FARMER_FOR_WEATHER = SERVER_ADDRESS + "/homePage/farmerHomePageForWeather";
	/** 首页显示-告警列表 */
	public static final String HOME_ALARM_RECORD_QUERY_LIST = SERVER_ADDRESS + "/alarmRecord/queryAlarmecordList";
	/** 首页显示-未读告警数量 */
	public static final String HOME_ALARM_NO_READ_COUNT = SERVER_ADDRESS + "/alarmRecord/queryAlarmRecordNoReadCount";
	/** 首页显示-告警阅读 */
	public static final String HOME_ALARM_READ = SERVER_ADDRESS + "/alarmRecord/updateAlarmRecordRead";

	/*
	 * 运维日志
	 */
	/** 运维日志-状态记录 */
	public static final String LOG_STATUS_REPORT_LIST = SERVER_ADDRESS + "/deviceStateRecord/queryDeviceStateList";
	/** 运维日志-操作日志 */
	public static final String LOG_OPERATE_REPORT_LIST = SERVER_ADDRESS + "/sysOptRecord/querySysOptRecordList";
	/** 运维日志-删除操作记录 */
	public static final String LOG_OPERATE_REPORT_DELETE = SERVER_ADDRESS + "/sysOptRecord/delSysOptRecord";
	/** 运维日志-添加系统操作记录 */
	public static final String LOG_OPERATE_REPORT_ADD_SYSTEM_RECORD = SERVER_ADDRESS + "/sysOptRecord/addSysOptRecord";
	/** 运维日志-添加单点操作记录 */
	public static final String LOG_OPERATE_REPORT_ADD_SINGLE_RECORD = SERVER_ADDRESS
			+ "/sensorCtlRecord/addSensorCtrlRecord";

	/*
	 * 监控
	 */
	/** 设备-列表 */
	public static final String DEVICE_QUERY_DEVICE_LIST = SERVER_ADDRESS + "/device/queryDeviceList";
	/** 设备监控-物联网关列表（分页） */
	public static final String DEVICE_QUERY_IOTGATEWAY_LIST = SERVER_ADDRESS + "/device/queryIOTGatewayList";
	/** 设备监控-选择物联网关 */
	public static final String DEVICE_QUERY_IOTGATEWAY_SELECTION_LIST = SERVER_ADDRESS + "/device/queryIOTGatewayItem";
	/** 设备监控-物联网关信息 */
	public static final String DEVICE_QUERY_IOTGATEWAY = SERVER_ADDRESS + "/device/queryIOTGateway";
	/** 设备监控-物联网关信息及相关 */
	public static final String DEVICE_QUERY_IOTGATEWAY_INFO = SERVER_ADDRESS + "/device/queryIOTGatewayInfo";
	/** 设备监控-阀控器列表（分页） */
	public static final String DEVICE_QUERY_VALVECONTROL_LIST = SERVER_ADDRESS + "/device/queryValveControlList";
	/** 设备监控-关联的阀控器列表 */
	public static final String DEVICE_QUERY_RELATE_VALVECONTROL = SERVER_ADDRESS + "/device/queryRelateValveControl";
	/** 设备监控-(查询） 修改阀控器 */
	public static final String DEVICE_QUERY_AND_MODIFY_VALVECONTROL = SERVER_ADDRESS
			+ "/device/queryValveControlDevice";
	/** 设备监控-虚拟设备列表（分页） */
	public static final String DEVICE_QUERY_VIRTUAL_DEVICE_LIST = SERVER_ADDRESS + "/device/queryVirtualDeviceList";
	/** 设备监控-传感器列表（分页） */
	public static final String DEVICE_QUERY_SENSOR_LIST = SERVER_ADDRESS + "/sensor/querySensorListForFarm";
	/** 设备监控-添加设备 */
	public static final String DEVICE_ADD_DEVICE = SERVER_ADDRESS + "/device/addDevice";
	/** 设备监控-查询设备 */
	public static final String DEVICE_QUERY_DEVICE = SERVER_ADDRESS + "/device/queryDevice";
	/** 设备监控-编辑设备 */
	public static final String DEVICE_UPDATE_DEVICE = SERVER_ADDRESS + "/device/updateDevice";
	/** 设备监控-删除设备 */
	public static final String DEVICE_DELETE_DEVICE = SERVER_ADDRESS + "/device/deleteDevice";
	/** 设备监控-控制设备 */
	public static final String DEVICE_CONTROL_DEVICE = SERVER_ADDRESS + "/device/deviceCommand";
	/** 设备监控-控制传感器 */
	public static final String DEVICE_CONTROL_SENSOR = SERVER_ADDRESS + "/sensor/sensorCommand";
	/** 设备监控-传感器详情 */
	public static final String DEVICE_CONTROL_QUERY_SENSOR_INFO = SERVER_ADDRESS + "/sensor/querySensorInfoBySensorId";
	/** 设备监控-更新设备的deviceid */
	public static final String DEVICE_UPDATE_DEVICE_ID = SERVER_ADDRESS + "/device/updateDeviceDeviceId";
	/** 设备监控-导出设备和传感器 */
	public static final String DEVICE_EXPORT_DEVICE_AND_SENSOR = SERVER_ADDRESS + "/device/exportAllDeviceAndSensor";

	/*
	 * 分类管理
	 * 
	 */
	/** 分类管理-大分类列表 */
	public static final String SENSOR_TYPES_COLL_QUERY_SENSOR_TYPES_COLL = SERVER_ADDRESS
			+ "/sensorTypesColl/querySensorTypesColl";
	/** 分类管理-添加大分类 */
	public static final String SENSOR_TYPES_COLL_ADD_SENSOR_TYPES_COLL = SERVER_ADDRESS
			+ "/sensorTypesColl/addSensorTypesColl";
	/** 分类管理-删除大分类 */
	public static final String SENSOR_TYPES_COLL_DEL_SENSOR_TYPES_COLL = SERVER_ADDRESS
			+ "/sensorTypesColl/delSensorTypesColl";
	/** 分类管理-编辑大分类 */
	public static final String SENSOR_TYPES_COLL_UPDATE_SENSOR_TYPES_COLL = SERVER_ADDRESS
			+ "/sensorTypesColl/updateSensorTypesColl";
	/** 分类管理-选择大分类 */
	public static final String SENSOR_TYPES_COLL_QUERY_SENSOR_TYPES_COLL_FOR_NAME_ANDID = SERVER_ADDRESS
			+ "/sensorTypesColl/querySensorTypesCollForNameAndId";
	/** 分类管理-小分类列表 */
	public static final String SENSOR_TYPE_QUERY_SENSOR_TYPE_LIST = SERVER_ADDRESS
			+ "/sensorType/queryForSensorTypeList";
	/** 分类管理-小分类详情 */
	public static final String SENSOR_TYPE_QUERY_SENSOR_TYPE_BY_ID = SERVER_ADDRESS + "/sensorType/querySensorTypeById";
	/** 分类管理-添加小分类 */
	public static final String SENSOR_TYPE_ADD_SENSOR_TYPE = SERVER_ADDRESS + "/sensorType/addSensorType";
	/** 分类管理-编辑小分类 */
	public static final String SENSOR_TYPE_UPDATE_SENSOR_TYPE = SERVER_ADDRESS + "/sensorType/updateSensorType";
	/** 分类管理-删除小分类 */
	public static final String SENSOR_TYPE_DEL_SENSOR_TYPE = SERVER_ADDRESS + "/sensorType/delSensorType";

	/*
	 * 策略
	 */
	/** 传感器列表 */
	public static final String FLOW_CTRL_SENSOR_LIST = SERVER_ADDRESS + "/sensor/querySensorItemForFarm";
	/** 流程控制列表 */
	public static final String FLOW_CTRL_QUERY_FLOW_CTRL_LIST = SERVER_ADDRESS + "/flowCtrl/queryFlowCtrlList";
	/** 流程控制操作 */
	public static final String FLOW_CTRL_QUERY_FLOW_CTRL_COMMAND = SERVER_ADDRESS + "/flowCtrl/flowFlowCommand";
	/** 流程控制删除 */
	public static final String FLOW_CTRL_QUERY_FLOW_CTRL_DELETE = SERVER_ADDRESS + "/flowCtrl/delFlowCtrl";
	/** 流程控制添加 */
	public static final String FLOW_CTRL_QUERY_FLOW_CTRL_ADD = SERVER_ADDRESS + "/flowCtrl/addFlowCtrl";
	/** 流程控制编辑 */
	public static final String FLOW_CTRL_QUERY_FLOW_CTRL_EDIT = SERVER_ADDRESS + "/flowCtrl/updateFlowCtrl";
	/** 触发控制列表 */
	public static final String TRIGGER_QUERY_TRIGGER_LIST = SERVER_ADDRESS + "/trigger/queryTriggerList";
	/** 触发控制操作 */
	public static final String FLOW_CTRL_QUERY_TRIGGER_CTRL_COMMAND = SERVER_ADDRESS + "/trigger/triggerCommand";
	/** 触发控制删除 */
	public static final String TRIGGER_QUERY_TRIGGER_DELETE = SERVER_ADDRESS + "/trigger/delTrigger";
	/** 触发控制添加 */
	public static final String TRIGGER_QUERY_TRIGGER_ADD = SERVER_ADDRESS + "/trigger/addTrigger";
	/** 触发控制编辑 */
	public static final String TRIGGER_QUERY_TRIGGER_EDIT = SERVER_ADDRESS + "/trigger/updateTrigger";
	/** 子流程控制列表 */
	public static final String FLOW_TASK_QUERY_FLOW_TASK_BY_FLOW_ID_FOR_DATE = SERVER_ADDRESS
			+ "/flowTask/queryFlowTaskByFlowIdForDate";
	/** 子流程详情 */
	public static final String FLOW_CTRL_FLOW_TASK_DETAIL = SERVER_ADDRESS + "/flowTask/queryFlowTaskDetailInfo";

}

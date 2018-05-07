package restService.jersey.util;

import java.util.UUID;

public class IdUtil {
	public static String getId() {
		return getId( "" );
	}
	
	public static String getId( String prefix ) {
		UUID uuid=UUID.randomUUID();
		return prefix+uuid.toString();
	}

	public static String newPublicFundId() {
		return getId( "P-" );
	}
	
	public static String newPublicFundManagerId() {
		return getId( "M-" );
	}
	
	public static String newManagerCompanyId() {
		return getId( "CP-" );
	}

	public static String newFundId() {
		return getId( "F-" );
	}

	public static String newStockIndexId() {
		return getId( "STX-" );
	}

	public static String newFundMonthNetValueId() {
		return getId( "MNV-" );
	}
	
	public static String newFundDailyNetValueId() {
		return getId( "DNV-" );
	}

	public static String newReportEventId() {
		return getId( "RE-" );
	}

	public static String newFundSeasonNetValueId() {
		return getId( "NV-" );
	}

	public static String newMainFinancialSeasonIndexId() {
		return getId( "FI-" );
	}

	public static String newFundSeasonChangementId() {
		return getId( "FC-" );
	}

	public static String newFundManagerSeasonReportId() {
		return getId( "FMR-" );
	}

	public static String newFundProfitId() {
		return getId( "FP-" );
	}

	public static String newFundChargeStructureId() {
		return getId( "FCS-" );
	}

	public static String newAssetCombinationId() {
		return getId( "AC-" );
	}

	public static String newFundAnnouncementId() {
		return getId( "FA-" );
	}

	public static String newSmsMessageId() {
		return getId( "SM-" );
	}

	public static String newUserInfoId() {
		return getId( "U-" );
	}

	public static String newUserInfoForOTCId(){
		return getId("UO-");
	}

	public static String newFundSubscriptionId() {
		return getId( "FS-" );
	}

	public static String newRequestRecordId() {
		return getId( "REC-" );
	}

	public static String newInvestSurveyId() {
		return getId( "SR-" );
	}

	public static String newFundDocumentId() {
		return getId( "DOC-" );
	}

	public static String newFundAccessCodeId() {
		return getId( "" );
	}

	public static String newUserWechatInfoId() {
		return getId( "WC-" );
	}

	public static String newMeetingId() {
		return getId( "MT-" );
	}
	
	public static String newFundSeasonReportProgressId() {
		return getId( "FSR-" );
	}
	
	public static String newPrivateAssetId() {
		return getId( "X-" );
	}

	public static String newStockOptionId(){
		return getId("SO-");
	}

	public static String newBrokerInfoId(){
		return getId("BI-");
	}

	public static String newStockHistoricalVolatilityId(){
		return getId("SHV-");
	}

	public static String newStockImpliedVolatilityId(){
		return getId("SIV-");
	}

	public static String newWebSocketId() {
		return getId("WS-");
	}
	
}


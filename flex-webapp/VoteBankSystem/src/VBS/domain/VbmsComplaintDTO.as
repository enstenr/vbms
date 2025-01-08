package VBS.domain
{[RemoteClass(alias="com.vbms.domain.VbmsComplaintDTO")]
	public class VbmsComplaintDTO
	{
		public function VbmsComplaintDTO()
		{
		}
		
		public var  complaintid:String;
		public var desc:String;
		public var raisedby:String;
		public var complaintby:String;
		public var priority:String;
		public var status:String;
		public var comments:String;
		public var  month_name:String;
		public var year_name:String;
		public var date_name:String;
		public var area:String;
		public var created_dttm:String;
		public var updated_dttm:String;
		public var count:int;
		public var createdby:String;
		public var fromDate:String;
		public var toDate:String;
		
	}
}
package VBS.domain
{[RemoteClass(alias="com.vbms.domain.VbmsUserDTO")]
	public class VbmsUserDTO
	{
		public function VbmsUserDTO()
		{
		}
		
		public var userId:Number;
		public var userName:String;
		public var userLogin:String;
		public var userPassword:String;
		public var userMenu:String;
		public var isSelected:Boolean=false;
		public var status:String;
	 	public var accessType:String;
		
		
	}
} 
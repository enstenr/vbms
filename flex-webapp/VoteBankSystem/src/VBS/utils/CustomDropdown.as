package VBS.utils
	

{import spark.components.DropDownList;
import spark.components.supportClasses.DropDownController;
	public class CustomDropdown extends DropDownList
	{
		
		public function CustomDropdown()
		{
			 
			  super();
		}
		
		public function get controller():DropDownController {
			return super.dropDownController;
		}
		
		public function set controller(value:DropDownController):void {
			
			 
			super.dropDownController = value;
			
		}
		
	}
}

	
	 	
	
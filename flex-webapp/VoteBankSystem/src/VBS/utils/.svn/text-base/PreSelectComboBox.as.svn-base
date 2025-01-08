 
package VBS.utils
{
	import mx.controls.ComboBox;
	import mx.controls.Alert;
	
	public class PreSelectComboBox extends ComboBox
	{
		 private var _selectedValue:String;
         private var bSelectedValueSet:Boolean = false;
         private var bDataProviderSet:Boolean = false;
         
         
          // Override committ, this may be called repeatedly 
         override protected function commitProperties():void
         {
           try{
	            // invoke ComboBox version 
	            super.commitProperties();
	
	            // If value set and have dataProvider 
	            if (bSelectedValueSet && bDataProviderSet)
	            {
	               // Set flag to false so code won't be called until selectedValue is set again 
	               bSelectedValueSet=false;
	               // Loop through dataProvider 
	               for (var i:int=0;i<this.dataProvider.length;i++)
	               {
	                  // Get this item's data 
	                  var item:String = this.dataProvider[i].data;
	   
	                  // Check if is selectedValue 
	                  if(item == _selectedValue)
	                  {
	                     // Yes, set selectedIndex 
	                     this.selectedIndex = i;
	                     break;
	                  }
	               }
	            }
	         }catch(err:Error){
	         	;
	         }
         }

        
         // Trap dataProvider being set 
         override public function set dataProvider(o:Object):void
         {
            // invoke ComboBox version 
            super.dataProvider = o;

            // This may get called before dataProvider is set, so make sure not null and has entries 
            if (o!=null && o.length)
            {
               // Got it, set flag 
               bDataProviderSet = true;
            }
         }

        
         // set for selectedValue 
         public function set selectedValue(s:String):void
         {
            // Set flag 
            bSelectedValueSet = true;
            // Save value 
            _selectedValue = s;
            // Invalidate to force commit 
            invalidateProperties();
         }
	}
}
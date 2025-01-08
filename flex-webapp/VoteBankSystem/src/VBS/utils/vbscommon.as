import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.rpc.events.FaultEvent;

var accessType:ArrayCollection=new ArrayCollection([{label:"SuperUser",data:"SUPERUSER"},{label:"Admin",data:"ADMIN"},{label:"Operator",data:"USER"}]);
var statusAC:ArrayCollection=new ArrayCollection([{label:"Active",data:"ACTIVE"},{label:"Inactive",data:"INACTIVE"}]);
var complaintstatusAC:ArrayCollection=new ArrayCollection([{label:"Open",data:"OPEN"},{label:"Closed/FeedBack Pending",data:"FP"},{label:"Closed",data:"CLOSED"},{label:"Cancelled",data:"CANCELLED"}]);

[Bindable]var voterAC:ArrayCollection=new ArrayCollection();
[Bindable]var complaintAC:ArrayCollection=new ArrayCollection( );


//Used for Schemes
var genderAC:ArrayCollection=new ArrayCollection([{label:"All",data:"ALL"},{label:"Male",data:"MALE"},{label:"Female",data:"FEMALE"}]);
var areaAC:ArrayCollection=new ArrayCollection([{label:"All",data:"ALL"},{label:"Lawspet",data:"LAWSPET"},{label:"Thatanchavady",data:"THATTANCHAVADY"}]);


private function faultHandler(event:FaultEvent):void{
	Alert.show(event.fault.faultString);
}

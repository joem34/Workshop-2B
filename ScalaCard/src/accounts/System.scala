package accounts

object System {
	type Concession = String
	
	var deviceCounter:Int = 0
	
	var allAccessDevices : List[AccessDevice] = List()
	var currentAccessDevices : Set[AccessDevice] = Set()
	var bannedAccessDevices : Set[AccessDevice] = Set()
	
	var accounts : Set[Account] = Set()
	
	val statusTypes : Set[String] = setUpStatusMapping
	val concessionRate : Map[String, Int] 
	                      = Map("Student"->5,
	                     		  "Adult"->10,
	                     		  "Child"->0)
	
	def newAccessDevice = {
		deviceCounter += 1
		val newDevice = new AccessDevice(deviceCounter)
		allAccessDevices = newDevice :: allAccessDevices
	}
	                     		  
	def banAccessDevice(ad:AccessDevice) {
		if (currentAccessDevices.contains(ad)) {
			currentAccessDevices -= ad
			bannedAccessDevices  += ad
		}
	}
	
	def activateDevice(ad:AccessDevice):Boolean = {
		var successful : Boolean = false;
		if (allAccessDevices.contains(ad)
				&& !currentAccessDevices.contains(ad)
				&& !bannedAccessDevices.contains(ad)) {
			currentAccessDevices += ad
		}
		return successful
	}
	
	def setUpStatusMapping : Set[String] = {
		var set : Set[String] = Set()
		set + "Enabled"
		set + "Disabled"
		return set
	}
	

}
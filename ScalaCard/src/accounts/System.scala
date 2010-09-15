package accounts

object System {
	type Concession = String
	
	var allAccessDevices : List[AccessDevice] = List()
	var currentAccessDevices : Set[AccessDevice] = Set()
	var bannedAccessDevices : Set[AccessDevice] = Set()
	
	var accounts : Set[Account] = Set()
	
	val statusTypes : Set[String] = setUpStatusMapping
	val concessionRate : Map[String, Int] 
	                      = Map("Student"->5,
	                     		  "Adult"->10,
	                     		  "Child"->0)
	
	def banAccessDevice(ad:AccessDevice) {
		if (currentAccessDevices.contains(ad)) {
			currentAccessDevices -= ad
			bannedAccessDevices  += ad
		}
	}
	
	def setUpStatusMapping : Set[String] = {
		var set : Set[String] = Set()
		set + "Enabled"
		set + "Disabled"
		return set
	}
	

}
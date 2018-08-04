# SaveMesender
Updates
get location
	send sms
	la = latitude, lo = longitude
	every 30 mins()
	{
	onLocationChange(100m, sendSMS())
	}
	onPersonTravelling(30min, sendSMS())
	onSOSButtonPressed(sendSMS("MANUAL"))

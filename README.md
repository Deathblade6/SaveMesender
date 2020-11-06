# SaveMesender
An app to send location of trapped survivors using SMS instead of mobile data to accomodate for low network strength and congestion during a natural crisis

SQLITE save la and lo as decimals

1. Without netwrok
	get location
	send sms
	la = latitude, lo = longitude
	every 30 mins()
	{
	onLocationChange(100m, sendSMS())
	}
	onPersonTravelling(30min, sendSMS())
	onSOSButtonPressed(sendSMS("MANUAL"))




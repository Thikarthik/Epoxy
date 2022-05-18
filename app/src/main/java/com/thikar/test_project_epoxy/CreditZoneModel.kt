package com.thikar.test_project_epoxy

data class CreditZoneModel(
    val position:Int,
    val isChecked:Boolean = false,
    val displayName:String?=null,
    val amount:Long,
    val tip:String?=null,
    val backgroundColor:String,
    val displayColor:String,
    val logoUrl:ArrayList<String>,
    val startDate:Long,
    val endDate:Long,
    val isSelected:Boolean=false
) {
}

//"displayName": "0-45 Days",
//"amount": 464.79,
//"tip": "Next repayment due on 26 Mar 2022",
//"backgroundColor": "#DDFFE0",
//"displayNameColor": "#28A144",
//"logoUrl": {},
//"startDate": 1646048158,
//"endDate": 1649936158
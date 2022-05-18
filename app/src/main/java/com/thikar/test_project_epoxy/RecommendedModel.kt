package com.thikar.test_project_epoxy

data class RecommendedModel(
    val position:Int,
    val isChecked:Boolean,
    val displayName:String,
    val amount:Long,
    val tip:String,
    val backgroundColor:String,
    val displayColor:String
)

//"recommended": {
//    "displayName": "Recommended",
//    "amount": 464.79,
//    "tip": "Pay now to avoid CIBIL impact",
//    "backgroundColor": "#FFFCDF",
//    "displayNameColor": "#212121",
//    "logoUrl": null,
//    "startDate": null,
//    "endDate": null
//}
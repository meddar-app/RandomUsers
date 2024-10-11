package com.codabee.randomusers.model

 data class ApiResults(val results:List<User>)

 data class User(
     val nat:String,
     val gender:String,
     val email:String,
     val phone:String,
     val cell:String,
     val name: Name,
     val location: Location,
     val dob:Dob,
     val picture:Picture
 )

 data class Name(
     val title:String,
     val first:String,
     val last:String,
 )

data class Location(
    val street : Street,
    val city:String,
    val state:String,
    val country:String,
    val postcode:Any,
    val latitude:String,
    val longitude:String
)

data class Street(
    val number:Int,
    val name:String
)

data class Dob(
    val date:String,
    val age:Int,
)

data class Picture(
    val large:String,
    val medium:String,
    val thumbnail:String,
)

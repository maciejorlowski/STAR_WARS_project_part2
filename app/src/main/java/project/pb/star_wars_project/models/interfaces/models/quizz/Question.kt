package project.pb.star_wars_project.models.interfaces.models.quizz

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "question")
class Question (

    @PrimaryKey (autoGenerate = true)
    var id : Int,
    var question : String,
    var correct_answer : String,
    var incorrect_answers : List<String>

)
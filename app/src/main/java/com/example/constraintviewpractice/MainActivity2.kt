package com.example.constraintviewpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bookNames = arrayOf(
            "Don Quixote",
            "Alice's Adventures in Wonderland",
            "The Adventures of Huckleberry Finn",
            "The Adventures of Tom Sawyer",
            "Treasure Island",
            "Pride and Prejudice",
            "Wuthering Heights",
            "Jane Eyre",
            "Moby Dick",
            "The Scarlet Letter",
            "Gulliver's Travels",
            "The Pilgrim's Progress",
            "A Christmas Carol",
            "David Copperfield",
            "A Tale of Two Cities",
            "Little Women",
            "Great Expectations",
            "The Hobbit, or, There and Back Again",
            "Frankenstein, or, the Modern Prometheus",
            "Oliver Twist",
            "Uncle Tom's Cabin",
            "Crime and Punishment",
            "Madame Bovary: Patterns of Provincial life",
            "The Return of the King",
            "Dracula",
            "The Three Musketeers",
            "Brave New World",
            "War and Peace",
            "To Kill a Mockingbird",
            "The Wizard of Oz",
            "Les Misérables",
            "The Secret Garden",
            "Animal Farm",
            "The Great Gatsby",
            "The Little Prince",
            "The Call of the Wild",
            "20,000 Leagues Under the Sea",
            "Anna Karenina",
            "The Wind in the Willows",
            "The Picture of Dorian Gray",
            "The Grapes of Wrath",
            "Sense and Sensibility",
            "The Last of the Mohicans",
            "Tess of the d'Urbervilles",
            "Harry Potter and the Sorcerer's Stone",
            "Heidi",
            "Ulysses",
            "The Complete Sherlock Holmes",
            "The Count of Monte Cristo",
            "The Old Man and the Sea",
            "The Lion, the Witch, and the Wardrobe",
            "The Hunchback of Notre Dame",
            "Pinocchio",
            "One Hundred Years of Solitude",
            "Ivanhoe",
            "The Red Badge of Courage",
            "Anne of Green Gables",
            "Black Beauty",
            "Peter Pan",
            "A Farewell to Arms",
            "The House of the Seven Gables",
            "Lord of the Flies",
            "The Prince and the Pauper",
            "A Portrait of the Artist as a Young Man",
            "Lord Jim",
            "Harry Potter and the Chamber of Secrets",
            "The Red & the Black",
            "The Stranger",
            "The Trial",
            "Lady Chatterley's Lover",
            "Kidnapped: The Adventures of David Balfour",
            "The Catcher in the Rye",
            "Fahrenheit 451",
            "A Journey to the Center of the Earth",
            "Vanity Fair",
            "All Quiet on the Western Front",
            "Gone with the Wind",
            "My Ántonia",
            "Of Mice and Men",
            "The Vicar of Wakefield",
            "A Connecticut Yankee in King Arthur's Court",
            "White Fang",
            "Fathers and Sons",
            "Doctor Zhivago",
            "The Decameron",
            "Nineteen Eighty-Four",
            "The Jungle",
            "The Da Vinci Code",
            "Persuasion",
            "Mansfield Park",
            "Candide",
            "For Whom the Bell Tolls",
            "Far from the Madding Crowd",
            "The Fellowship of the Ring",
            "The Return of the Native",
            "Sons and Lovers",
            "Charlotte's Web",
            "The Swiss Family Robinson",
            "Bleak House",
            "Père Goriot",
        )


        val bundle:Bundle? = intent.extras

        val indexNumber = bundle?.getInt("randomNumber",1)

        val bookTitleView:TextView = findViewById(R.id.titleBookView)

        val selectedBook: String = if (indexNumber != null && indexNumber in bookNames.indices) {
            // Check if indexNumber is not null and is within the range of bookNames indices
            bookNames[indexNumber]
        } else {
            // Handle the case where indexNumber is null or out of bounds
            "No book for you this week"
        }

        bookTitleView.setText("""This week 
            |Book name is 
            |$selectedBook """.trimMargin())

        val shareButton:Button = findViewById(R.id.shareButton)

        shareButton.setOnClickListener(){
            val intent = Intent(Intent.ACTION_SEND)
            intent. putExtra(Intent.EXTRA_TEXT, "Check out this book: $selectedBook")
            intent.type = "text/plain"

            if (intent.resolveActivity(packageManager) != null) {
                // Start the activity if there's an app available
                startActivity(Intent.createChooser(intent, "Share via"));
            } else {
                // Handle the case where no app can handle the intent
                Toast.makeText(this, "No app found to handle this action", Toast.LENGTH_SHORT).show()
            }
        }


    }}


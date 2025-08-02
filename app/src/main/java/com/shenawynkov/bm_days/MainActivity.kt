package com.shenawynkov.bm_days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shenawynkov.bm_days.ui.theme.BM_daysTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BM_daysTheme {
               MainScreen(contacts)
            }

        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}
val contacts = listOf(
    Contact(
        id = 1,
        name = "Alice Johnson",
        title = "Product Manager",
        phone = "+1 (555) 123-4567",
        imageURL = "https://randomuser.me/api/portraits/women/1.jpg"
    ),
    Contact(
        id = 2,
        name = "Michael Smith",
        title = "Senior Developer",
        phone = "+1 (555) 234-5678",
        imageURL = "https://randomuser.me/api/portraits/men/2.jpg"
    ),
    Contact(
        id = 3,
        name = "Emma Brown",
        title = "UX Designer",
        phone = "+1 (555) 345-6789",
        imageURL = "https://randomuser.me/api/portraits/women/3.jpg"
    ),
    Contact(
        id = 4,
        name = "James Wilson",
        title = "Data Scientist",
        phone = "+1 (555) 456-7890",
        imageURL = "https://randomuser.me/api/portraits/men/4.jpg"
    ),
    Contact(
        id = 5,
        name = "Olivia Davis",
        title = "Marketing Lead",
        phone = "+1 (555) 567-8901",
        imageURL = "https://randomuser.me/api/portraits/women/5.jpg"
    ),
    Contact(
        id = 6,
        name = "William Taylor",
        title = "Backend Engineer",
        phone = "+1 (555) 678-9012",
        imageURL = "https://randomuser.me/api/portraits/men/6.jpg"
    ),
    Contact(
        id = 7,
        name = "Sophia Martinez",
        title = "QA Engineer",
        phone = "+1 (555) 789-0123",
        imageURL = "https://randomuser.me/api/portraits/women/7.jpg"
    ),
    Contact(
        id = 8,
        name = "Benjamin Lee",
        title = "Mobile Developer",
        phone = "+1 (555) 890-1234",
        imageURL = "https://randomuser.me/api/portraits/men/8.jpg"
    ),
    Contact(
        id = 9,
        name = "Ava Thompson",
        title = "HR Manager",
        phone = "+1 (555) 901-2345",
        imageURL = "https://randomuser.me/api/portraits/women/9.jpg"
    ),
    Contact(
        id = 10,
        name = "Daniel Anderson",
        title = "DevOps Engineer",
        phone = "+1 (555) 012-3456",
        imageURL = "https://randomuser.me/api/portraits/men/10.jpg"
    )
)

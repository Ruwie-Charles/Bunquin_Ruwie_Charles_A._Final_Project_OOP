# Bunquin_Ruwie_Charles_A._Final_Project_OOP
I Project Overview.
  The AnimalQuiz project is an interactive console-based quiz application in Java that educates users about animals through multiple-choice questions. It employs object-oriented programming principles with classes for questions, quiz management, and a user-friendly menu. Users can add custom questions with options, ensuring flexibility and scalability. The program features robust input validation and error handling, providing a smooth and engaging experience. Predefined questions help users get started, and the quiz tracks scores, offering immediate feedback on answers. Designed for simplicity and education, this project fosters learning about animals in an enjoyable and interactive way.

II OOP Principle.
1. Encapsulation
The Question class encapsulates its data (questionText, options, and correctAnswer) by making them private and providing controlled access through public getter methods, ensuring data security and proper usage.
2. Abstraction
The Quiz class hides the complexities of quiz management (like storing questions and handling user input) and exposes only essential methods (addQuestion and startQuiz) to interact with the quiz.
3. Composition in Relationships
Composition is used in the relationship between Quiz and Question, as the Quiz class contains an ArrayList of Question objects, showing a "has-a" relationship where a Quiz is composed of multiple Question instances.
4. Dynamic Behavior
Dynamic behavior is evident in the program as the Quiz class interacts with user input during runtime, allowing for a different set of questions or quiz flow each time, based on the data provided and the user's actions.

III SDG.
  The Animal Quiz program aligns with SDG 4, Quality Education, by providing an engaging and interactive learning experience for elementary-grade students. The quiz promotes knowledge about animals, fostering curiosity and enhancing critical thinking skills. Through a user-friendly interface and fun, educational content, the program encourages students to learn while testing their understanding of various animal characteristics. The inclusion of customizable questions allows for tailored educational content, making the learning experience accessible and enjoyable for young students, thus supporting inclusive, quality education and lifelong learning.

IV Instruction for program.
1st users need to run the program first
2nd the users can choose if they want to add or start some quiz
3rd if the user choose 2 to start quiz they will be given some question for them to answer and once done their score will be reaveled
4th once they done they can go add some question they prefered for the other students to try.
5th the new question will automaticaly be sent once they start the quiz again
6th once they done they can either choose if they want to exit or continue answering and making some question

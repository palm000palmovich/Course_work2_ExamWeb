**date: 21.11.2024**

This code is a web emulation of creating lists 
of exam questions. It can add questions with their answers,
remove question-answer pairs, and finally remove random 
questions from the general list depending on the number 
that you specify yourself!

Join http://localhost:8080 in Postman and run my programm
application and let's start!

1) enter http://localhost:8080/exam/java/add , 
switch to POST mode and in the body 
in json format enter pair question-answer.
For example: 
 `{
   "question": "Are you wild chicken?",
   "answer": "No, I'm a pet porcupine!"
   }`
        
**P.S. I think this would be the best exam :)**

So, after pressing on trigger "Send", Post - request will 
return a positive response if there is no such combination 
in the list yet, otherwise it will not add your pair and 
will quarrel a little.

2) After several added question-answer pairs, I recommend 
checking if everything was added correctly.
Switch to GET-mode in Postman and enter 
http://localhost:8080/exam/java (simply remove "/add" in 
last request).

__So, we made sure that everything was ok, now let’s go_ 
delete everything to ~~hell~~)_

3) Deleting occurs on the same principle as adding. 
You just need to add “/remove” to the Post request, and 
specify a question-answer pair in json format in the body 
of the request.

`{
"question": "Remove a wild chicken?",
"answer": "Let's go!"
}`

**P.S.The author has nothing against wild chickens**

4) After all these manipulations, you can display a list of our
   questions in a random order and in the quantity in which we
   We'll decide for ourselves. I feel this code will appeal to those who are used to
   decide everything for yourself :)
Enter http://localhost:8080/exam/get/{amount}

Instead of {amount}, enter any number that does not exceed 
the size of your list of questions, otherwise a 
BadRequestException with strange Russian characters will 
be thrown.
Therefore, if you don’t want such surprises, then consider 
the fact that your list is finite :)


This is still a simple web program; the **JavaQuestionsService**
and **ExaminerServiceImpl** services and the 
**JavaQuestionController** and **ExamController** controllers are 
responsible for its operation.

**But exactly after this moment I will write tests with mocks 
so that I can understand the operation of the algorithm 
based on errors :)**

  _P.S. Love you Java ♡_

`public class ReplyFromJava {
    public static void main(String[] args) {
        System.out.println("Love you too bro)";
    }
}`

**date 22.11.2024**

I added Unit tests for Services. Now for convenience you can 
poke into the tests. In test for ExaminerServiceImpl added
mock for method getRandom() and getAllQuestions().
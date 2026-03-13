# 2026-03-12 16:36

## Thoughts So Far
I reviewed the project instructions and understood that the project consists of three programs: a logger, an encryption program, and a driver program. The driver will launch the other programs and communicate with them through pipes. The encryption program will use a Vigenère cipher and the logger will record activity with timestamps.

## Plan for This Session
- Creating the repository
- Setting up the initial project structure
- Creating the main program files

## Session Reflection
I created the project repository and the initial files needed for the project.


# 2026-03-13 00:51

## Thoughts So Far
After setting up the repository, I began implementing the logger program since it is the simplest part of the system.

## Plan for This Session
- Implementing the logger program
- Ensuring it reads from standard input
- Write the log messages to a file with timestamps

## Session Reflection
The logger program was implemented successfully. It reads messages from standard input and writes them to a log file with timestamps in the required format.


# 2026-03-13 01:18

## Thoughts So Far
I wanted to organize the repository and prevent unnecessary files from being tracked.

## Plan for This Session
- Creating a `.gitignore` file
- Ignore `.class` and `.log` files

## Session Reflection
I created a `.gitignore` file and configured it to ignore compiled Java files and log files.


# 2026-03-13 01:24

## Thoughts So Far
While testing the project I realized I wanted to include the sample log output in the repository.

## Plan for This Session
- Modified `.gitignore`
- Allowed the log file to be tracked

## Session Reflection
I updated `.gitignore` so the log file can be committed to the repository.


# 2026-03-13 05:05

## Thoughts So Far
After finishing the logger, I moved on to the encryption program. This program must support PASS, ENCRYPT, DECRYPT, and QUIT commands and implement the Vigenère cipher.

## Plan for This Session
- Implementing encryption logic
- Implementing decryption logic
- Handling the command parsing

## Session Reflection
I implemented the encryption program and tested encryption and decryption manually. I confirmed that the program returns an error when the password has not been set.


# 2026-03-13 09:06

## Thoughts So Far
The next step was to implement the driver program, which is responsible for launching the logger and encryption programs and communicating with them using pipes.

## Plan for This Session
- Starting the logger process
- Starting the encryption program process
- Implementing a command menu
- Sending commands between programs

## Session Reflection
I implemented the driver program and connected it to both processes using pipes. The driver program now handles user commands and maintains a history of strings used during the session.


# 2026-03-13 09:26

## Thoughts So Far
After implementing the main functionality, I began testing the entire system.

## Plan for This Session
- Running the full program
- Testing the password, encrypt, decrypt, history, and quit commands
- Saving a sample log file

## Session Reflection
I tested the full system and verified that the logger correctly records commands and results. I added `log.txt` containing a sample run of the program.


# 2026-03-13 09:30

## Thoughts So Far
During testing I wanted to make compilation easier for running the project.

## Plan for This Session
- Adjusting `.gitignore`
- Added all the compiled class files in the repository

## Session Reflection
I removed the class files from `.gitignore` so they remain in the repository. This allows the project to run more easily without requiring compilation first.
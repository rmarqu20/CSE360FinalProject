import csv
import random

class Student:
    ID = 0
    firstName = ""
    lastName = ""
    progAndPlan = ""
    acadLevel = ""
    asuRITE = ""

def generateASUID():
    #1214774210
    #1000000000
    #9999999999
    return random.randint(1000000000, 9999999999)

def writeStudents(students,  name):
    with(open(name + ".csv", 'w', newline="\n")) as csvfile:
        csvwriter = csv.writer(csvfile, delimiter=',')
        
        print(name)
        for student in students:
            csvwriter.writerow([str(student.ID), student.firstName, student.lastName, student.progAndPlan, student.acadLevel, student.asuRITE])
            print([str(student.ID), student.firstName, student.lastName, student.progAndPlan, student.acadLevel, student.asuRITE])
            
def writeAttendance(students, name):
    with(open(name + ".csv", 'w', newline="\n")) as csvfile:
        csvwriter = csv.writer(csvfile, delimiter=',')
        
        print(name)
        for student in students:
            csvwriter.writerow([str(student.asuRITE), str(random.randint(1, 75))])
            print([str(student.asuRITE), str(random.randint(1, 75))])

numStudents = int(input("How many students?: "))
numDates = int(input("How many rosters?: "))

students = []
firstNames = ["James", "John", "Robert", "Michael", "William", "David", "Richard"]
lastNames = ["Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller"]
progPlans = ["Computer Science MCS", "Mechanical Engineering MCS", "Computer Science BCS"]
acadLevels = ["Graduate", "Undergrad"]
    
for i in range(0, numStudents):
    student = Student()
    student.ID = generateASUID()
    student.firstName = firstNames[(i + random.randint(1, 7)) % 7]
    student.lastName = lastNames[(i + random.randint(1, 7)) % 7]
    student.progAndPlan = progPlans[(i + random.randint(1, 3)) % 3]
    student.acadLevel = acadLevels[(i + random.randint(1, 2)) % 2]
    student.asuRITE = student.firstName[0] + student.lastName[0:4] + str(random.randint(0, 9))
        
    students.append(student)
    
writeStudents(students, "roster")

for i in range(0, numDates):
    studentsInAttendance = []
    for x in range(0, numStudents - 1):
        randomInt = random.randint(1, 10)
        if (randomInt >= 6):
            studentsInAttendance.append(students[x])     
    writeAttendance(studentsInAttendance, "attendance" + str(i))

#########
# Project
#########
HMH_Palindrome_Exercise

##########
# Comments
##########
This project takes the names of 5 dwarves (Gimli, Fili, Ilif, Ilmig, Mark) and finds all possible combinations of names
that result in a palindrome (i.e. a word or sentence that is spelled the same forward and backward - "taco cat").  The names
are treated as case insentive when performing the palindrome check.  So GimliIlmig is a palindrome.

Designer's Note: If I were a drinking dwarf (I swear I'm not... a dwarf) then I would fight about the order of the names.  So
in this exercise the palindrome FiliIlif is treated differently and reported separately than IlifFili.

#########
# Compile
#########
To command line compile follow these steps from the project root directory:

cd src
javac PalindromeExercise.java
java PalindromeExercise

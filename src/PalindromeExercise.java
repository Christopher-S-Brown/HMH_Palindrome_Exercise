import java.util.*;

/**
 * This class will take a list of names and determine which combination of two or more names results in a palindrome
 *
 * Created on 11/29/17
 *
 * @author Christopher Brown
 * @version 1.1
 *
 * Changes in v1.1 (11/30/17):
 *      - Ordered the palindrome combinations via TreeSet so that it is easy to compare output across tests
 *      - Added display method for Set as well as common iterator output method
 *      - Break out of loopForPalindromeFrontToBack as soon as we've exhausted the potential list elements
 *      - Added additional test cases
 */
public class PalindromeExercise {
  /*
   * List of names to combine into palindromes
   */
  private List<String> potentialPalindromeNames = new ArrayList<>();
  
  /*
   * Palindrome name combinations
   */
  private Set<String> palindromeNameCombinations = new TreeSet<>();
  
  /*
   * Add a name to our list of potential palindrome name combinations
   *
   * @param name    The name to add to the list of potential palindrome combinations
   */
  public void addName(final String name) {
    potentialPalindromeNames.add(name);
  }
  
  /*
   * Take a list of names and display them, comma separated, with the corresponding fluff text
   *
   * @param names     The list of names to display, comma separated
   * @param fluffText The fluff text to prepend to the list of names
   */
  private void displayListNames(final List<String> names,
                                final String fluffText) {
    System.out.println(fluffText);
    iteratorLoop(names.iterator());
  }
  
  /*
   * Take a set of names and display them, comma separated, with the corresponding fluff text
   *
   * @param names     The set of names to display, comma separated
   * @param fluffText The fluff text to prepend to the list of names
   */
  private void displaySetNames(final Set<String> names,
                               final String fluffText) {
    System.out.println(fluffText);
    iteratorLoop(names.iterator());
  }
  
  /*
   * Common iterator loop that displays all names in the iterator, comma separated
   *
   * @param iterator The String iterator from which to print the names, comma separated
   */
  private void iteratorLoop(final Iterator<String> iterator) {
    String output = new String();
    while(iterator.hasNext()) {
      String currentName = iterator.next();
      if(output.length() > 0) {
        output = output.concat(", ");
      }
      output = output.concat(currentName);
    }
    System.out.println(output);
  }
    
  /*
   * Loop through the list of potential names to find the combination of two or more names that results in a palindrome
   */
  public void determineAllPalindromes() {
    // First display all the names in our list
    displayListNames(potentialPalindromeNames,
        "The names in our potential palindrome list are: ");
  
    loopForPalindromeFrontToBack(new String(), new HashSet<>());
  
    displaySetNames(palindromeNameCombinations,
        "The palindrome combinations are: ");
  }
  
  /*
   * Loop through the list of provided names and recursively check every combination of names for a palindrome
   *
   * @param currentCandidate The current combination of names
   * @param currentSet       The current set of list indexes that have already been processed, so we can skip those indexes
   */
  private void loopForPalindromeFrontToBack(final String currentCandidate,
                                            final Set<Integer> currentSet) {
    // Loop through the entire name list skipping items we've already processed in the set
    for(Integer x=0; x<potentialPalindromeNames.size(); x++) {
      if(currentSet.contains(x)) {
        continue;
      }
      
      // Add the current item to the set of processed indexes
      Set<Integer> newSet = new HashSet<>();
      newSet.addAll(currentSet);
      newSet.add(x);
      
      // Add the current name and check for a palindrome
      String currentName = potentialPalindromeNames.get(x);
      String palindromeCandidate = currentCandidate + currentName;
      if(isPalindrome(palindromeCandidate)) {
        // We found a palindrome so store it
        palindromeNameCombinations.add(palindromeCandidate);
      }
      
      // Recursively loop through the list - but only if there are unprocessed elements remaining
      if(newSet.size() < potentialPalindromeNames.size()) {
        loopForPalindromeFrontToBack(palindromeCandidate, newSet);
      }
    }
  }
  
  /*
   * Check a string against its reverse string
   *
   * @param palindromeCandidate Check if the string is a palindrome
   * @return boolean            True if the string and its reverse are identical (ignoring case),
   *                            False if the string and its reverse are different
   */
  private boolean isPalindrome(final String palindromeCandidate) {
    String reverseCandidate = new StringBuilder(palindromeCandidate).reverse().toString();
    return palindromeCandidate.equalsIgnoreCase(reverseCandidate);
  }
  
  public static void main(String args[]) {
    // HMH provided exercise
    System.out.println("HMH Provided Exercise:");
    PalindromeExercise palindromeExercise = new PalindromeExercise();
    palindromeExercise.addName("Gimli");
    palindromeExercise.addName("Fili");
    palindromeExercise.addName("Ilif");
    palindromeExercise.addName("Ilmig");
    palindromeExercise.addName("Mark");
    palindromeExercise.determineAllPalindromes();
    System.out.println();
  
    // Test Case #1
    //  Note: Even though the order of the names has changed the output had better be the same
    System.out.println("Test Case #1:");
    PalindromeExercise palindromeExercise1 = new PalindromeExercise();
    palindromeExercise1.addName("Ilmig");
    palindromeExercise1.addName("Gimli");
    palindromeExercise1.addName("Mark");
    palindromeExercise1.addName("Fili");
    palindromeExercise1.addName("Ilif");
    palindromeExercise1.determineAllPalindromes();
    System.out.println();
  
    // Test Case #2
    //  Note: Even though the order of the names has changed the output had better be the same
    System.out.println("Test Case #2:");
    PalindromeExercise palindromeExercise2 = new PalindromeExercise();
    palindromeExercise2.addName("Fili");
    palindromeExercise2.addName("Mark");
    palindromeExercise2.addName("Gimli");
    palindromeExercise2.addName("Ilif");
    palindromeExercise2.addName("Ilmig");
    palindromeExercise2.determineAllPalindromes();
    System.out.println();
  
    // Test Case #2
    //  Note: Even though the order of the names has changed the output had better be the same
    System.out.println("Test Case #3:");
    PalindromeExercise palindromeExercise3 = new PalindromeExercise();
    palindromeExercise3.addName("Mark");
    palindromeExercise3.addName("Ilmig");
    palindromeExercise3.addName("Fili");
    palindromeExercise3.addName("Gimli");
    palindromeExercise3.addName("Ilif");
    palindromeExercise3.determineAllPalindromes();
    System.out.println();
  }
}

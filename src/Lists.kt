// Do not remove or rename the package
package lists

/*
* The following functions are helper functions that I am providing
*/

/*
* Extend the List class with a "tail" getter to get the tail of a list.
* Below is an example of how you would use tail
*    val a = listOf(1,2,3)
*    val t = a.tail
*    println("tail of $a is $t") // prints [2,3]
*/
val <T> List<T>.tail: List<T>
get() = drop(1)

/*
* Extend the List class with a "head" getter to get the head of a list.
* Below is an example of how you would use head
*    val a = listOf(1,2,3)
*    val h = a.head
*    println("head of $a is $h") // prints 1
*/
val <T> List<T>.head: T
get() = first()

/* 
* The isPrime function takes as input an Int
*      x : an Int object to test
* and returns a Boolean
*      true  if x is a prime
*      false if x is not a prime
*/
fun isPrime(x : Int) : Boolean {
    for (i in 2..(x-1)) {
        if (x % i == 0) {
            return false
        }    
    }
    return true
}

/* The compose function takes as input
*     f - A function that takes as input a value of type T and returns a value of type T
*     g - A function that takes as input a value of type T and returns a value of type T
*  and returns as output the composition of the functions
*     f(g(x))
*/
fun<T> compose(f: (T)->T,  g:(T) -> T) : (T) -> T = { f(g(it)) }

/* Be sure to document 
   your functions
   describing inputs and outputs and what the function does
*/
fun countingNumbers(limit : Int?) : List<Int>? {
    if(limit == null){
        return null;
    }
    val numList : MutableList<Int> = mutableListOf();

    for(i in 1..limit){
        numList.add(i);
    }

    return numList;
}

fun evenNumbers(size : Int?) : List<Int>? {

    if(size == null)
        return null;

    val numList : MutableList<Int> = mutableListOf();

    var i : Int = 1;
    while(numList.size < size){
        if(i % 2 == 0)
            numList.add(i);
        i += 1;
    }

    return numList;
}

fun primeNumbers(size : Int?) : List<Int>? {
    if(size == null)
        return null;

    val numList : MutableList<Int> = mutableListOf();

    var i : Int = 1;
    while(numList.size < size){
        if(isPrime(i))
            numList.add(i);
        i += 1;
    }

    return numList;
}

fun subLists(elements : List<Int>?) : List<List<Int>>? {
    if(elements == null)
        return null;

    val lists : MutableList<List<Int>> = mutableListOf();

    for(i in 0 until elements.size - 1){
        lists.add(elements.slice(0..i));
    }

    return lists;
}

fun countElements(lists : List<List<Int>?>?) : Int? {
    if(lists == null)
        return 0

    var count = 0;

    for(list in lists){
        if(list == null){
            count += 0;
        }
        else{
            count += list.size;
        }
    }

    return count;
}

fun<T : Comparable<T>> merge(a : List<T>?, b : List<T>?) : List<T>? {
    if(a == null || b == null)
        return null;

    var merged : MutableList<T> = mutableListOf();

    var aIndex = 0;
    var bIndex = 0;
    while(aIndex < a.size - 1 || bIndex < b.size - 1){
        if(bIndex >= b.size || a.elementAt(aIndex).compareTo(b.elementAt(bIndex)) < 0){
            merged.add(a.elementAt(aIndex));
            aIndex += 1;
        }
        else if (aIndex >= a.size || a.elementAt(aIndex).compareTo(b.elementAt(bIndex)) >= 0){
            merged.add(b.elementAt(bIndex));
            bIndex += 1;
        }
    }

    return merged;
}
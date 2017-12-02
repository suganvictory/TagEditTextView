TagEdittextView is useful for adding the keyword by clicking enter (after type a character). And also you can add the keyword using add button on right top of the TagEdittext View. Sample app has been included for the reference.

Step 1. Add it in your root build.gradle at the end of repositories: (project build.gradle)
allprojects { 
repositories { ...
	maven { url 'https://jitpack.io' }
 } }


Step 2. Add the dependency (module build.gradle)
dependencies { 
compile 'com.github.suganvictory:TagEditTextView:0.1' 
}

For Kitkat to Nougat use below dependencies

dependencies { 
compile 'com.github.suganvictory:TagEditTextView:0.1.1' 
}

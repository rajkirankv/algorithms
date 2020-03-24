package newPackage;

import algsAndDS.Library;

class NewClass {
	public boolean newMethod() {
		return true;
	}

	public boolean useMethod() {
		Library library = new Library();
		return library.someLibraryMethod();
	}

}
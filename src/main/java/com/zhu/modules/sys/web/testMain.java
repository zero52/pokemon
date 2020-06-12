package com.zhu.modules.sys.web;

import java.util.Calendar;

public class testMain {

    public static void main(String[] args) {
/*		PySystemState state = new PySystemState();
	    PyObject clazz;
	    Py.getSystemState().path.append(Py.newString("C:\\Users\\41586\\Desktop"));
	    PyObject importer = state.getBuiltins().__getitem__(Py.newString("__import__"));
	    PyObject module = importer.__call__(Py.newString("IODemo"));
	    clazz = module.__findattr__("ClassName");
	    System.out.println(clazz);*/
        //printInt obj = (InterfaceName) clazz.__call__().__tojava__(InterfaceName.class);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JULY, 13);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_MONTH) + 100);
        System.out.println(calendar.get(Calendar.DATE));
    }

}

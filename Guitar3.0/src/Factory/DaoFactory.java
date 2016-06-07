package Factory;

import com.sun.org.apache.regexp.internal.recompile;

import jdbc.lianjie;
import jdbc.mysql;
import jdbc.sqlite;

public class DaoFactory {
	public lianjie createLianjie(String test){
		lianjie lianjie = null ;
		switch (test) {
		case "mysql":
			lianjie	= new mysql();
			break;
		case "sqlite":
			lianjie	= new sqlite();
			break;
		}
		return lianjie;
}
}

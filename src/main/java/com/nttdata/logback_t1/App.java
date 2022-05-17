package com.nttdata.logback_t1;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.logback_t1.entities.Client;
import com.nttdata.logback_t1.entities.ManagementTransactions;

/**
 * @author Fernando Pérez Nieto
 *
 */
public class App 
{
	/** Logger */
	static final Logger LOG = LoggerFactory.getLogger(App.class);
	
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        LOG.info("TRACE INIT");
		LocalDate bDay = LocalDate.of(1997, 4, 8);
		Client client = new Client("Alejandro", "Tellez", bDay);
		LOG.debug(client.toString());
		ManagementTransactions.launch(client);
        LOG.info("TRACE END");
    }
    
}

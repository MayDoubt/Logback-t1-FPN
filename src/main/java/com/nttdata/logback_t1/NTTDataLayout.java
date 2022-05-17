package com.nttdata.logback_t1;

import java.util.Date;

import com.nttdata.logback_t1.entities.StringUtilities;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class NTTDataLayout extends LayoutBase<ILoggingEvent> {

	/** Imprime prefijo */
	private String prefix;
	
	/** Imprime nombre de hilo */
	private boolean printThreadName = Boolean.TRUE;
	
	
	/**
	 * Genera el layout
	 * 
	 * @param event
	 * @return String
	 */
	@Override
	public String doLayout(ILoggingEvent event) {
		
		final StringBuilder sb = new StringBuilder();
		sb.append(StringUtilities.toStrBuilder((new Date(event.getTimeStamp()).toString()), " ", prefix, " ", event.getLevel().toString()));
		
		if(printThreadName) {
			sb.append(StringUtilities.toStrBuilder(" [", event.getThreadName(),"] "));
		}
		
		sb.append((StringUtilities.toStrBuilder(" ", event.getLoggerName(), " - ", event.getFormattedMessage(), "\n")));
		
		return sb.toString();
	}

}

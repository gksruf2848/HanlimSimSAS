package org.tain.working.load;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.utils.CurrentInfo;
import org.tain.working.load.tables.TblCampLoader;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoadWorking {

	public void doing() throws Exception {
		log.info("HANLIM-20220404 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			if (Boolean.TRUE) loadTblCamp();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TblCampLoader tblCampLoader;
	
	private void loadTblCamp() throws Exception {
		log.info("HANLIM-20220404 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) this.tblCampLoader.loading();
	}
}

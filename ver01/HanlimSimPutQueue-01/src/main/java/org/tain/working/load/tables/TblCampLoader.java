package org.tain.working.load.tables;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.jpa.domain.TblCamp;
import org.tain.jpa.repository.TblCampRepository;
import org.tain.tools.properties.ProjEnvParam;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TblCampLoader {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	@Autowired
	private TblCampRepository tblCampRepository;
	long id = 1L;
	
	public void loading() throws Exception {
		log.info("HANLIM-20220404 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			this.tblCampRepository.deleteAll();
		}
		
		if (Boolean.TRUE) {
			String fileName = this.projEnvParam.getBasePath() + File.separator + this.projEnvParam.getCampFile();
			String jsonData = StringTools.stringFromFile(fileName);
			List<TblCamp> lst = new ObjectMapper().readValue(jsonData, new TypeReference<List<TblCamp>>() {});
			lst.forEach(itm -> {
				itm.setId(id);
				this.tblCampRepository.save(itm);
				this.id ++;
			});
		}
	}
}

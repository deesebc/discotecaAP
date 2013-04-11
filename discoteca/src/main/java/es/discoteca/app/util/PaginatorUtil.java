/**
 * 
 */
package es.discoteca.app.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import es.discoteca.app.json.bean.JqGridRequest;
import es.discoteca.app.json.bean.JqGridResponse;

/**
 * @author xe29197
 * 
 */
@Component
public final class PaginatorUtil<C, J> {

	@Autowired
	protected Mapper mapper;

	public PaginatorUtil() {
		super();
	}

	public JqGridResponse<J> getBookJqGridRes(final Page<C> page, final Class<J> entity) {
		List<J> list2 = new ArrayList<J>();
		for (C disco : page.getContent()) {
			J bean = mapper.map(disco, entity);
			list2.add(bean);
		}
		JqGridResponse<J> exit = new JqGridResponse<J>();
		exit.setRows(list2);
		// Total de paginas
		exit.setTotal(Integer.toString(page.getTotalPages()));
		exit.setPage(Integer.toString(page.getNumber() + 1));
		exit.setRecords(Long.toString(page.getTotalElements()));
		return exit;
	}

	private Direction getDirection(final String sord) {
		Direction dir = Direction.DESC;
		if ("asc".equals(sord)) {
			dir = Direction.ASC;
		}
		return dir;
	}

	public Pageable getPageable(final JqGridRequest request) {
		int page = request.getPage() - 1;
		int rows = request.getRows();
		final Sort sort = new Sort(getDirection(request.getSord()), request.getSidx());
		final PageRequest exit = new PageRequest(page, rows, sort);
		return exit;
	}

	// private void method(final String filter) throws JsonProcessingException,
	// IOException {
	// ObjectMapper mapper = new ObjectMapper();
	// JsonNode jsonFilter = mapper.readTree(filter);
	// String groupOp = jsonFilter.get("groupOp").asText();
	// LOGGER.debug("groupOp :" + groupOp);
	// List<JsonNode> rules = jsonFilter.findValues("rules");
	// LOGGER.debug("Count Rules :" + rules.size());
	// for (JsonNode node : rules) {
	// LOGGER.debug("field :" + node.get("field").asText());
	// LOGGER.debug("op :" + node.get("op").asText());
	// LOGGER.debug("data :" + node.get("data").asText());
	// }
	// }

}

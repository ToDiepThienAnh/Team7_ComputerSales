package cybersoft.backend.finalproject.ecommerce.commondata;

import java.util.List;
import java.util.Optional;

import cybersoft.backend.finalproject.ecommerce.commondata.model.AbstractEntity;


public interface IGenericService<T extends AbstractEntity, ID> {
	List<T> findAll();
	Optional<T> findById(ID id);
	T save(T entity);
	T update(T entity);
	void deleteById(ID id);
}

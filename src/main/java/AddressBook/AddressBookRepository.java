package AddressBook;

/**
 * Created by sarrankanpathmanatha on 2/2/2017.
 */

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "Books", path = "Books")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Integer> {



}
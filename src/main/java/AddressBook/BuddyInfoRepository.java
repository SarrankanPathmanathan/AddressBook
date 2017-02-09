/**
 * Created by sarrankanpathmanatha on 2/1/2017.
 */

package AddressBook;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "buddies", path = "buddies")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Integer> {

    List<BuddyInfo> findByName(@Param("name") String name);

}
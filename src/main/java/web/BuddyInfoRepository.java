package web;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddies", path="buddies")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

}



package net.edinosmanovic.bookstore.models.data;

import net.edinosmanovic.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by eo on 6/19/17.
 */

@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, Integer>{

}

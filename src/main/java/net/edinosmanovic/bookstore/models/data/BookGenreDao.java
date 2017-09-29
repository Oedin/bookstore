package net.edinosmanovic.bookstore.models.data;

import net.edinosmanovic.bookstore.models.BookGenre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by eo on 6/22/17.
 */

@Repository
@Transactional
public  interface BookGenreDao extends CrudRepository<BookGenre, Integer> {
}

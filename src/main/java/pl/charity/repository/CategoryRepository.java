package pl.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.charity.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findFirstByName(String name);
    List<Category> findAll();




//for(
//    int i = 0; i<fundations.size();i ++)
//
//    {
//        print( < li >)print( < div >)print(fundation.get(i); print( </div >)print( < div > print(fundations.get(i + 1);
//        print( </div > print( </li >);
//    }

//    for(
//    int i = 0; i<fundations.size();i ++)
//
//    {
//        print( < li >)print( < div >)print(fundation.get(i); print( </div >)print( < div > print(fundations.get(i + 1);
//        print( </div > print( </li >);
//    }
//for(
//    int i = 0; i<fundations.size();i ++)
//
//    {
//        print( < li >);
//        print( < div >);
//        print(fundation.get(i); print( </div >);
//        print( < div >; print(fundations.get(i + 1); print( </div);
//        print( </li >);
//    }


//    <c:
//    forEach begin = "0"
//    end="fundations.size()"varStatus="loop"step="2"> <li th:each="index:${numbers.sequence(0,fundation.size())> <div> <c:out value="fundations.get(index).
//
//    getName()"></div> <div> <c:out value="fundations.get(index +1).
//
//    getName()"></div> </li> </c:forEach>
}


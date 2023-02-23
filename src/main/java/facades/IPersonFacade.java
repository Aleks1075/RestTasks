package facades;

import dtos.PersonDTO;
import errorhandling.PersonNotFoundException;

import java.util.List;

public interface IPersonFacade
{
    public PersonDTO addPerson(String fName, String lName, String phone);

    public PersonDTO deletePerson(int id) throws PersonNotFoundException;

    public PersonDTO editPerson(PersonDTO p) throws PersonNotFoundException;

    public PersonDTO getPersonById(int id) throws PersonNotFoundException;

    public List<PersonDTO> getAllPersons();
}

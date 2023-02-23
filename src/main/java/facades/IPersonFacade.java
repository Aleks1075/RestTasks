package facades;

import dtos.PersonDTO;

import java.util.List;

public interface IPersonFacade
{
    public PersonDTO addPerson(String fName, String lName, String phone);

    public PersonDTO deletePerson(int id) throws Exception;

    public PersonDTO editPerson(PersonDTO p) throws Exception;

    public PersonDTO getPersonById(int id) throws Exception;

    public List<PersonDTO> getAllPersons();
}

package br.com.bartie.apiTest.core;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bartie.app.core.ModelEntity;
import br.com.bartie.app.core.ModelDTO;

@ExtendWith(MockitoExtension.class)
public abstract class ModelApiServiceTest<
    Repo extends JpaRepository<T, Long>,
    T extends ModelEntity,
    DTO extends ModelDTO<DTO>>
{

    public ModelUnitTest<T, DTO> checker;

    protected void setChecker(ModelUnitTest<T, DTO> checker) {
        this.checker = checker;
        MockitoAnnotations.openMocks(this);
    }

    public void FindAll() {

        // Arrange

        // List<T> input = checker.mock.getList(25);

        // when(repository.findAll()).thenReturn(input);

        // Act

        // List<DTO> output = service.findAll();

        // Assert

        // checker.checkList(output, 25);

    }


}

// <Serv extends ModelService<Repo>, Mocked extends ModelMock<T, DTO>, Repo extends ModelRepository<T>, T extends ModelEntity, DTO extends ModelDTO> {





//     protected void FindList(int size) {

//         // Arrange

//         List<T> input = mock.getList(size);

//         when(repository.findAll()).thenReturn(input);

//         // Act

//         List<DTO> output = service.findAll();

//         // Assert

//         checkList(output, 25);

//     }

//     public void FindItem() {

//         // Arrange

//         T input = mock.get(2L);

//         when(repository.findById(input.getId())).thenReturn(Optional.of(input));

//         // Act

//         DTO output = service.find(input.getId());

//         // Assert

//         checkItem(output, input.getId());

//     }

//     public void CreateItem() {

//         // Arrange

//         T input = mock.get(10L);

//         when(repository.save(input)).thenReturn(input);

//         // Act

//         DTO output = service.create(input);

//         // Assert

//         checkItem(output, input.getId());

//     }

//     public void UpdateItem() {

//         // Arrange

//         T input = mock.get(14L);

//         when(repository.save(input)).thenReturn(input);

//         // Act

//         DTO output = service.update(input);

//         // Assert

//         checkItem(output, input.getId());

//     }

//     public void DeleteItem() {

//         // Arrange

//         T input = mock.get(7L);

//         when(repository.findById(input.getId())).thenReturn(Optional.of(input));

//         // Act

//         service.delete(input.getId());

//     }

//     public void CreateItemIsNull() {

//         // Arrange

//         T input = null;

//         // Act

//         Exception output = 
//             assertThrows(RequiredObjectIsNullException.class, () -> 
//                 { service.create(input); } );

//         // Assert

//         checkIsNullException(output);

//     }

//     public void UpdateItemIsNull() {

//         // Arrange

//         T input = null;

//         // Act

//         Exception output = 
//             assertThrows(RequiredObjectIsNullException.class, () -> 
//                 { service.update(input); } );

//         // Assert

//         checkIsNullException(output);


//     }

//     private void checkItem(DTO item)
//     { checkItem(item, item.getId()); }

//     abstract void checkItem(DTO person, Long id);

//     private void checkList(List<DTO> list, int size)
//     {

//         assertNotNull(list);
//         assertEquals(size, list.size());

//         list.stream().forEach(item -> checkItem(item));

//     }

//     private void checkIsNullException(Exception output)
//     {

//         assertEquals("it is not allowed to persist a null object!", output.getMessage());    

//     }



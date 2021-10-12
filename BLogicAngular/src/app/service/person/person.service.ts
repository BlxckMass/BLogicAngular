import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Person} from "../../model/person/person";
import {Post} from "../../model/person/post";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";

@Injectable()
export class PersonService {

  constructor(private http: HttpClient) {
  }

  getPersonById(id: bigint): Observable<Person> {
    return this.http.get('http://localhost:8080/api/person/get/' + id).pipe(map((data: any) => {
        return new Person(data.id, data.lastName, data.firstName, data.patronymic,
          new Post(data.post.id, data.post.name), data.birthDay, data.phone);
    }));
  }


  getAllPersons(): Observable<Person[]> {
    return this.http.get('http://localhost:8080/api/person/tree/getAll').pipe(map((data: any) => {
      return data;
    }));
  }

  updatePerson(person: Person): Observable<any> {
    return this.http.put('http://localhost:8080/api/person/update', person).pipe(map((data: any) => {
      return data;
    }));
  }

  deletePersonById(id: string): Observable<any> {
    const options = {
      body: {
        id: id
      },
    };
    return this.http.delete('http://localhost:8080/api/person/delete', options).pipe(map((data: any) => {
      return data;
    }));
  }

  getPosts(): any[] {
    let dat: any[] = [];
    this.http.get('http://localhost:8080/api/post/getAll').subscribe((data: any) => {
      for (let i = 0; i < data.length; i++) {
        dat.push(data[i]);
      }
    });
    return dat;
  }

  createNewPerson(): Person {
    return new Person('', '', '', '', new Post(0, ''), '', '');
  }
}

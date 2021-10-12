import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Task} from "../../model/document/task";

@Injectable()
export class TaskDocumentService {

  constructor(private http: HttpClient) {
  }

  getTaskById(id: bigint): Observable<Task> {
    return this.http.get('http://localhost:8080/api/document/task/get/' + id).pipe(map((data: any) => {
      return new Task(data.id, data.name, data.text, data.registrationNumber, data.dateOfRegistration,
        data.author, data.dateOfIssue, data.periodOfExecution, data.controlSign, data.executor, data.controller);
    }));
  }

  deleteTaskById(id: string): Observable<any> {
    const options = {
      body: {
        id: id
      },
    };
    return this.http.delete('http://localhost:8080/api/document/task/delete', options).pipe(map((data: any) => {
      return data;
    }));
  }
}

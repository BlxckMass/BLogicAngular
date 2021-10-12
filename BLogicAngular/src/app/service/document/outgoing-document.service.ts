import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../../model/document/task";
import {map} from "rxjs/operators";
import {Outgoing} from "../../model/document/outgoing";

@Injectable()
export class OutgoingDocumentService {

  constructor(private http: HttpClient) {
  }

  getOutgoingById(id: bigint): Observable<Outgoing> {
    return this.http.get('http://localhost:8080/api/document/outgoing/get/' + id).pipe(map((data: any) => {
      return new Outgoing(data.id, data.name, data.text, data.registrationNumber, data.dateOfRegistration,
        data.author, data.addressee, data.deliveryMethod);
    }));
  }

  deleteOutgoingById(id: string): Observable<any> {
    const options = {
      body: {
        id: id
      },
    };
    return this.http.delete('http://localhost:8080/api/document/outgoing/delete', options).pipe(map((data: any) => {
      return data;
    }));
  }
}

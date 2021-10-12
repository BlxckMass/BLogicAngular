import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Incoming} from "../../model/document/incoming";
import {errorObject} from "rxjs/internal-compatibility";

@Injectable()
export class IncomingDocumentService {

  constructor(private http: HttpClient) {
  }

  getIncomingById(id: bigint): Observable<Incoming> {
    return this.http.get('http://localhost:8080/api/document/incoming/get/' + id).pipe(map((data: any) => {
      return new Incoming(data.id, data.name, data.text, data.registrationNumber, data.dateOfRegistration,
        data.author, data.sender, data.addressee, data.outgoingNumber, data.outgoingDateOfRegistration);
    }));
  }

  deleteIncomingById(id: string): Observable<any> {
    const options = {
      body: {
        id: id
      },
    };
    return this.http.delete('http://localhost:8080/api/document/incoming/delete', options).pipe(map((data: any) => {
      return data;
    }));
  }

}

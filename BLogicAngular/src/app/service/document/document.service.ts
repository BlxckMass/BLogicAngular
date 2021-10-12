import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Document} from "../../model/document/document";

@Injectable()
export class DocumentService {

  constructor(private http: HttpClient) {
  }

  getAllDocuments(): Observable<Document[]> {
    return this.http.get('http://localhost:8080/api/document/tree/getAll').pipe(map((data: any) => {
      return data;
    }));
  }

}

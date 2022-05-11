import { TestBed } from '@angular/core/testing';

import { AuthAdm } from './auth-adm.service';

describe('AuthRelatorioService', () => {
  let service: AuthAdm;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthAdm);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidarEnvioComponent } from './validar-envio.component';

describe('ValidarEnvioComponent', () => {
  let component: ValidarEnvioComponent;
  let fixture: ComponentFixture<ValidarEnvioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValidarEnvioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValidarEnvioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
